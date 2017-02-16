```cs
// Modulo para validar cpf e retorna o cpf formatado sem outros caracteres
        public static bool validarCpf(string cpf, out string cpf_formatado)
        {
            cpf_formatado = null;
            int i = 0, restoDig1 = 0, somaDig1 = 0, restoDig2 = 0, somaDig2 = 0;
            // remove caracteres
            cpf = cpf.Replace(" ", "").Replace("-", "").Replace("_", "").Replace(".", "").Replace("/", "").Replace("\\", "").Replace(",", "");

            // verifica se tem 11 digitos
            if (cpf.Length != 11)
                return false;

            // verifica se é uma sequencia
            for (i = 1; i < 11; i += 1)
                if (cpf[0].Equals(cpf[i]))
                    restoDig1 += 1;

            if (restoDig1 == 10)
                return false;
            restoDig1 = 0;

            // realiza as somas para validação
            for (i = 0; i < 10; i += 1)
            {
                if (i < 9)
                    somaDig1 += int.Parse(cpf[i].ToString()) * (10 - i);
                somaDig2 += int.Parse(cpf[i].ToString()) * (11 - i);
            }

            restoDig1 = somaDig1 % 11;
            if (restoDig1 < 2)
                restoDig1 = 0;
            else
                restoDig1 = 11 - restoDig1;

            restoDig2 = somaDig2 % 11;
            if (restoDig2 < 2)
                restoDig2 = 0;
            else
                restoDig2 = 11 - restoDig2;

            if (restoDig1.ToString() == cpf[9].ToString() && restoDig2.ToString() == cpf[10].ToString())
            {
                cpf_formatado = cpf; // Retorna o cpf formatado sem caracteres
                return true;
            }
            return false;
        }
```
