package com.josh.humansApp.services;

import com.josh.humansApp.dtos.HumanDto;
import org.springframework.data.domain.Page;

public interface HumanService {

    Page<HumanDto> getAllHumans(int page, int per);

    HumanDto getHuman(Long id);

    HumanDto createHuman(HumanDto humanDto);

    HumanDto updateHuman(Long id, HumanDto humanDto);

    String deleteHuman(Long id);

}
