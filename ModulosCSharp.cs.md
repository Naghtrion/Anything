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
