package com.xjt.business;

import com.xjt.entity.Optionscombolist;
import com.xjt.entity.Optionsset;

import java.util.List;

public interface OptionssetBusinessService {

    void insertGlobalOptionSet(Optionsset optionsset, List<Optionscombolist> optionscombolists);

    void batchInsertOptionSet(List<Optionsset> optionssets,List<Optionscombolist> optionscombolists);
}
