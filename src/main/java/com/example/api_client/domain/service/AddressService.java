package com.example.api_client.domain.service;

import java.util.List;
import java.util.stream.Collectors;
import com.example.api_client.domain.dto.ResponseDto;
import com.example.api_client.domain.entity.Address;
import com.example.api_client.domain.dto.AddressDto;
import com.example.api_client.domain.enumeration.Status;
import com.example.api_client.domain.repository.AddressRepository;
import com.example.api_client.domain.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {
    
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ResponseDto responseDto;

    AddressRepository addressRepository;

    public ResponseDto saveAddress(Address address) {
        responseDto.setId(addressRepository.save(address).getId());
        responseDto.setMenssage("Cliente incluído com sucesso...");
        responseDto.setStatus(Status.SUCCESS.value());
        return responseDto;
    }

    public List<AddressDto> getAllAddresses() {
        List<AddressDto> listAllAddressesDto = addressRepository.findAll().stream()
                .map(Address -> modelMapper.map(Address, AddressDto.class))
                .collect(Collectors.toList());
        return listAllAddressesDto;
    }

    public AddressDto getAddressById(Long id) {
        return modelMapper.map(addressRepository.findById(id).get(), AddressDto.class);
    }

    public ResponseDto updateAddress(Address address) {    
        var id = address.getId();
        var existAddress = addressRepository.findById(id);
        if (existAddress.isEmpty()){
            responseDto.setMenssage("ID do Endereço inválido...");
            responseDto.setStatus(Status.ERROR.value());
        }else{
            responseDto.setId(addressRepository.save(address).getId());
            if(address.getId() > 0){
                addressRepository.save(address);
                responseDto.setMenssage("Endereço alterado com sucesso...");
                responseDto.setStatus(Status.SUCCESS.value());
            }else{
                responseDto.setMenssage("ID do Endereço inválido...");
                responseDto.setStatus(Status.ERROR.value());
            }
            
            
        }          
        
        return responseDto;
    }
}
