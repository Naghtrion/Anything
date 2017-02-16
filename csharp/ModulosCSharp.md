# Modulos ou codigos que talvez reutilize...
## C# tempo de execução...

```cs
long micro = DateTime.Now.Ticks; // tempo agora
// modulo ou codigo aqui
Console.WriteLine(micro - DateTime.Now.Ticks); // tempo antes de iniciar menos o de agora
Console.ReadKey();
```

## C# remover acentos de uma string
```cs
public static string removeAcentos(string texto)
{
    string comAcentos = "ÄÁÂÀÃäáâàãÉÊËÈéêëèÍÎÏÌíîïìÖÓÔÒÕöóôòõÜÚÛüúûùÇçÑñ";
    string semAcentos = "AAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUuuuuCcNn";
    for (int i = 0; i < comAcentos.Length; i += 1)
      texto = texto.Replace(comAcentos[i].ToString(), semAcentos[i].ToString());
    return texto;
}
```

## Modulo para por todas as inicias das palavras em maiúsculo
```cs
        public static string upperCaseWords(string frase)
        {
            Char[] chars = frase.ToLower().ToCharArray();
            if (chars[0] != ' ')
                chars[0] = Convert.ToChar(chars[0].ToString().ToUpper());
            for (int i = 0; i < chars.Length; i += 1)
                if (chars[i] == ' ' && chars[i + 1] != ' ')
                    chars[i + 1] = Convert.ToChar(chars[i + 1].ToString().ToUpper());
            return new string(chars);
        }
        ```
