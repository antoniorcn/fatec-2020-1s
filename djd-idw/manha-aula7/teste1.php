    <html>
   
    <body>
    <h1>Arquivo PHP</h1>
    <p>Isso vai aparecer no navegador</p>
    <?php
        $a = 10;
        $b = $a * 15;
       
        echo "Variavel B: $b";
       
        if ($b > 100)
        {
            ?>
                <p>Variavel B é maior que 100</p>
            <?php
        }
        else
        {
            ?>
                <p>Variavel B é menor que 100</p>
            <?php
        }
    ?>
   
    <?php
        for ($i=0; $i < 20; $i++)
        {
            ?>
            <p><?=$i?></p>
            <?php
        }
    ?>
    </body>
</html>