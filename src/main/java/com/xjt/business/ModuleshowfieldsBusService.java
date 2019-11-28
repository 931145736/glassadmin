package com.xjt.business;

import com.xjt.dto.ModuleshowfieldsReqDto;
import com.xjt.entity.Moduleshowfields;

import java.util.List;

public interface ModuleshowfieldsBusService {

    void insertModuleFields(List<Moduleshowfields> moduleshowfields);


    void deleteFieldsByModuleName(ModuleshowfieldsReqDto reqDto);
}
