<html>  
    <body>

        <p>Este paragrafo vai para o navegador</p>

        <?php 
            # Este texto não vai para o navegador
            $a = 1;

            if ($a > 4) { 
        ?>
            <p>Valor de a é maior que 4</p>
            <p><?=$a?>
        <?php
            } else { 
        ?>
            <p>Valor de a não é maior que 4</p>
            <?=$a?>
        <?php
            }
        ?>

        <p>Este paragrafo também vai para o navegador</p>

    </body>
</html>