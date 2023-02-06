package com.studenti.uninsubria.emotionalsongs.ClientES.Model;

//Asghar Luqman, 740940, VA
//Zuffellato Cristian, 740274, VA
//Basilico Andrea, 741414, VA
//Faraj Nour, 739889, VA

import com.studenti.uninsubria.emotionalsongs.ClientES.View.ViewFactory;

/**
 * @author luqmanasghar
 */
public class Model {

    private static Model model;
    private final ViewFactory viewFactory;

    public Model(){
        this.viewFactory = new ViewFactory();
    }

    public static synchronized Model GetInstance(){
        if(model == null)
            model = new Model();

        return model;
    }

    public ViewFactory GetViewFactory(){
        return viewFactory;
    }
}
