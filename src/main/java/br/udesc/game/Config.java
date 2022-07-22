package br.udesc.game;

import br.udesc.game.common.MaterialFactory;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;

public class Config {

    public static final Material MATERIAL_TERRENO_ABISMO = MaterialFactory.newMaterial(Color.BROWN);
    public static final Material MATERIAL_TERRENO_PANTANO = MaterialFactory.newMaterial(Color.LIGHTBLUE);
    public static final Material MATERIAL_TERRENO_PASTAGEM = MaterialFactory.newMaterial(Color.LIGHTGREEN);
    public static final Material MATERIAL_TERRENO_FLORESTA = MaterialFactory.newMaterial(Color.GREEN);
    public static final Material MATERIAL_TERRENO_COLINA = MaterialFactory.newMaterial(Color.DARKGRAY);
    public static final Material MATERIAL_TERRENO_MONTANHA = MaterialFactory.newMaterial(Color.GRAY);

    public static final int TAMANHO_CASA = 200;

    public static final int SCENE_WIDTH = 800;
    public static final int SCENE_HEIGHT = 600;



    
}
