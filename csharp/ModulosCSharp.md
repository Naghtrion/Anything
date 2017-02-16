# Modulos ou codigos que talvez reutilize...

## Tempo de execução...

```cs
long micro = DateTime.Now.Ticks; // tempo agora
// modulo ou codigo aqui
Console.WriteLine(micro - DateTime.Now.Ticks); // tempo antes de iniciar menos o de agora
Console.ReadKey();
```

## Remover acentos de uma string
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

## Por todas as inicias das palavras em maiúsculo
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

## Alinhar um vetor para exebição
```cs
public static void alignToDisplay(String[] vetor)
{
    int i, k;
    string[] split = vetor[0].Split('|');
    int[] size = new int[split.Length];

    // saber qual linha é a maior em cada coluna
    for (k = 0; k < split.Length; k += 1)
        for (i = 0; i < vetor.Length && vetor[i] != null; i += 1)
        {
            split = vetor[i].Split('|');
            if (split[k].Length > size[k])
                size[k] = split[k].Length;
        }

    // ajusta as colunas
    for (i = 0; i < vetor.Length && vetor[i] != null; i += 1)
    {
        split = vetor[i].Split('|');
        vetor[i] = "";
        for (k = 0; k < split.Length; k += 1)
            vetor[i] += split[k].PadRight(size[k] + 4, ' ');
    }
}
```
