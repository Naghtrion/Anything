String msg = e.getMessage();
// loop para censurar palavras
        for (String palavras : main.getConfig().getStringList("Censura.Palavras")) {
            if (msg.toLowerCase().contains(palavras.toLowerCase())) {
                msg = msg.replace(palavras, main.getConfig().getString("Censura.Censurado").replace("&", "§"));
            }
        }
        e.setMessage(msg);
