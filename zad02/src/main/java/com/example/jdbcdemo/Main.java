//package com.example.jdbcdemo;

import com.example.jdbcdemo.domain.Music;
import com.example.jdbcdemo.service.MusicService;

import java.sql.SQLException;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
        MusicService musicService = new MusicService();
        Music utwor = new Music("autor","title");
        musicService.addMusic(utwor);
    }
}
