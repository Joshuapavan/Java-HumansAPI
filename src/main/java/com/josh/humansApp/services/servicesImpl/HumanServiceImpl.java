package com.josh.humansApp.services.servicesImpl;

import com.josh.humansApp.dtos.HumanDto;
import com.josh.humansApp.entities.Human;
import com.josh.humansApp.repositories.HumansRepository;
import com.josh.humansApp.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HumanServiceImpl implements HumanService {

    @Autowired
    HumansRepository humansRepository;
    @Override
    public Page<HumanDto> getAllHumans(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        Page<Human> humanPage =  this.humansRepository.findAll(pageRequest);

//        return humanList.stream().map(human -> this.humanToHumanDto(human)).collect(Collectors.toList());
        return humanPage.map(this::humanToHumanDto);
    }

    @Override
    public HumanDto getHuman(Long id) {
        return humanToHumanDto(this.humansRepository.findById(id).get());
    }

    @Override
    public HumanDto createHuman(HumanDto humanDto) {
        Human human = this.humanDtoToHuman(humanDto);

        human.setFirstName(humanDto.getFirstName());
        human.setLastName(humanDto.getLastName());
        human.setAge(humanDto.getAge());
        human.setAdult(humanDto.getAge() >= 18);

        if(humanDto.getFirstName().isEmpty() && !humanDto.getLastName().isEmpty()) {
            human.setFirstName(humanDto.getFirstName());
        }else{
            human.setFullName(humanDto.getFirstName() + " " + humanDto.getLastName());
        }

        return this.humanToHumanDto(this.humansRepository.save(human));
    }

    @Override
    public HumanDto updateHuman(Long id, HumanDto humanDto) {
        Human human = this.humansRepository.findById(id).get();
        human.setFirstName(humanDto.getFirstName());
        human.setLastName(humanDto.getLastName());
        human.setAge(humanDto.getAge());

        human.setAdult(humanDto.getAge() >= 18);

        if(!humanDto.getFirstName().isBlank() && !humanDto.getLastName().isBlank()){
            human.setFullName(humanDto.getFirstName()+" "+humanDto.getLastName());
        }else{
            human.setFullName(humanDto.getFirstName());
        }

        return this.humanToHumanDto(this.humansRepository.save(human));
    }

    @Override
    public String deleteHuman(Long id) {
        this.humansRepository.deleteById(id);
        Optional<Human> human = this.humansRepository.findById(id);

        if(human.isPresent()){
            return "Unable to Delete Human with id: "+id;
        }else{
            return "Deleted Human with id: "+id;
        }
    }

    private HumanDto humanToHumanDto(Human human){
        HumanDto humanDto =  new HumanDto();
        humanDto.setId(human.getId());
        humanDto.setFirstName(human.getFirstName());
        humanDto.setLastName(human.getLastName());
        humanDto.setAge(human.getAge());
        humanDto.setFullName(human.getFullName());
        humanDto.setAdult(human.isAdult());

        return humanDto;
    }

    private Human humanDtoToHuman(HumanDto humanDto){
        Human human =  new Human();
        human.setFirstName(humanDto.getFirstName());
        human.setLastName(humanDto.getLastName());
        human.setAge(humanDto.getAge());

        return human;
    }
}
