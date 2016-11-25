## Pegar o arquivo para salvar em sql BLOB  

    /**
     * @param $archive
     * @return array
     * return array[active] = boolean, true em caso de sucesso
     * return array[error]  = Mensagem com o erro
     * return array[0] = $archive_nome
     * return array[1] = $archive_tipo
     * return array[2] = $archive_conteudo
     */
    public static function getSourceArchive($archive)
    {
        if ($archive == null)
            return [
                'active' => false,
                'error'  => 'Erro, envie um arquivo!'
            ];

        $_upload = [
            'tamanho'   => 2097152, // 2MB
            'extensoes' => ['.jar','.png','.PNG','.cs','.pdf'],
            'erros'     => [
                '0' => 'Não houve erro',
                '1' => 'O tamanho do arquivo ultrapassa o limite',
                '2' => 'O tamanho do arquivo ultrapassa o limite',
                '3' => 'O upload do arquivo foi feito parcialmente',
                '4' => 'Não foi feito o upload do arquivo']
        ];

        if ($archive['error'] != 0)
            return [
                'active' => false,
                'error'  => $_upload["erros"][$archive["error"]]
            ];

        $archive_name = $archive['tmp_name'];
        $archive_tamanho = $archive['size'];
        $archive_tipo = $archive['type'];
        $archive_nome = $archive['name'];

        $extensao = strtolower(strrchr($archive_nome, "."));

        if (array_search($extensao, $_upload['extensoes']) === false)
            return [
                'active' => false,
                'error'  => "O arquivo contem uma extensão não permitida!"
            ];

        if ($_upload['tamanho'] < $archive_tamanho)
            return [
                'active' => false,
                'error'  => "O arquivo enviado é muito grande, envie arquivos de até 2MB"
            ];

        $fp = fopen($archive_name, "rb");
        $archive_conteudo = fread($fp, $archive_tamanho);
        fclose($fp);
        return [
            'active' => true,
            '0'      => $archive_nome,
            '1'      => $archive_tipo,
            '2'      => $archive_conteudo
        ];
    }
