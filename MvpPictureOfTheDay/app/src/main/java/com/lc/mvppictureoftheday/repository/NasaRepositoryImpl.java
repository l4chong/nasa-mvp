package com.lc.mvppictureoftheday.repository;

import com.lc.mvppictureoftheday.models.NasaItem;

/**
 * Created by larrychong on 2017-07-30.
 */

public class NasaRepositoryImpl implements NasaRepository {
    @Override
    public NasaItem getNasaItem() {
        NasaItem item = new NasaItem();
        item.setUrl("https://upload.wikimedia.org/wikipedia/commons/a/a8/Lol_LOL.png");
        item.setTitle("Test");
        return item;
    }
}
