package com.naghtrion.nomedoplugin;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;

public class Main extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        //Código ao ligar
    	saveDefaultConfig();  // Salva a configuração padrao
        getLogger().log(Level.INFO, "Plugin iniciado com sucesso!");
    }

    @Override
    public void onDisable()
    {
        //Código ao desligar
    	saveConfig(); // Salva a configuração
        getLogger().log(Level.INFO, "Plugin desligado com sucesso!");
    }
}
