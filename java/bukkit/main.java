package com.naghtrion.nomedoplugin;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

public class NomeDoPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        //Código ao ligar
        getLogger().log(Level.INFO, "Plugin iniciado com sucesso!");
    }

    @Override
    public void onDisable()
    {
        //Código ao desligar
        getLogger().log(Level.INFO, "Plugin desligado com sucesso!");
    }
}
