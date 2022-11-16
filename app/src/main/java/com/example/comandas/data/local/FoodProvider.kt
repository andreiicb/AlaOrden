package com.example.comandas.data.local

import com.example.comandas.R

class FoodProvider {

    companion object{

        val FoodList = listOf<Food>(
            Food(
                "Hamburguesa",
                "Una jugosa hamburguesa de 225 gr. de carne Angus, sazonada con nuestra mezcla de especias y servida con lechuga, tomate, cebolla roja, pepinillos y mayonesa en un pan artesanal.",
                120.00,
                R.drawable.hamburguesa
            ),
            Food(
                "Pizza",
                "Se trata de un pan plano horneado, habitualmente de forma redonda, elaborado con harina de trigo, sal, agua y levadura, cubierto con salsa de tomate y queso.",
                190.00,
                R.drawable.pizza
            ),
            Food(
                "Hot Dogs",
                "3 panecillos largos llenos con una salchicha de Frankfurt, que se consume caliente, y untado de mostaza ligeramente dulce.",
                100.00,
                R.drawable.hotdogs
            ),
            Food(
                "Nachos",
                "Especialidad del norte de México y sur de los Estados Unidos consistente en pedazos triangulares de tortilla de maíz, fritos y bañados con queso amarillo derretido. Fuera de México es usual consumirlos con diversas salsas (guacamole o mayonesa), queso, frijoles o con carne asada.",
                150.00,
                R.drawable.nachos
            ),
            Food(
                "Quesadillas",
                "Antojito que consiste en una tortilla de masa de maíz doblada a la mitad en forma de media luna, rellena con queso fresco para derretir o algún otro guiso (tinga, papa, hongos, picadillo, cuitlacoche, rajas, etc.) y cocida en comal o frita.",
                120.00,
                R.drawable.quesadillas
            )
        )

        val DrinkList = listOf<Food>(
            Food(
                "Michelada",
                "Bebida que se prepara con cerveza clara u obscura, el vaso en el que se sirve se escarcha con jugo de limón, sal y chile en polvo. Adicional a eso se le añade jugo de maggi, salsa inglesa, chile en polvo, salsa valentina y jugo de limón a la cerveza para poderle dar un sabor mas picosito e interesante a la bebida.",
                80.00,
                R.drawable.michelada
            ),
            Food(
                "Coca cola",
                "Es un refresco azucarado de color marrón oscuro o negro debido al caramelo de su composición. Posee cafeína. Dos de los ingredientes originales y de donde obtiene el nombre son hojas de coca y semillas de Cola acuminata. Bebida muy refrescante, la cual puede ser traida con un vaso y hielos para conservar su temperatura.",
                35.00,
                R.drawable.cocacola
            ),
            Food(
                "Agua de horchata",
                "Es una bebida que se prepara con granos de arroz remojados en agua que después se muelen y se mezclan con agua endulzada; al final se aromatiza con canela y se le añaden leche y azucar para otorgarle un sabor mas dulce y refrescante.",
                30.00,
                R.drawable.aguadehorchata
            ),
            Food(
                "Agua de jamaica",
                "Es una bebida común en México, América Central y el Caribe y básicamente es una infusión preparada con los cálices de los hibiscos. Es muy refrescante cuando se sirve fría y relajante cuando se sirve caliente, pero la mayoría de las veces se sirve fría.",
                30.00,
                R.drawable.aguadejamaica
            ),
            Food(
                "Tonicol",
                "Es un refresco mexicano, hecho con ingredientes de más alta calidad como lo son el extracto natural de vainilla, agua carbonatada, ácido citrico y azúcar para ofrecernos una bebida dulce y refrescante.",
                35.00,
                R.drawable.tonicol
            )
        )

        val AppetizerList = listOf<Food>(
            Food(
               "Dedos de queso",
                "Los Dedos de Queso son trocitos de queso mozzarella empanizados, perfectos para degustar con salsa catsup, salsa picante, tu receta de dip favorito o con el ingrediente que prefieras. Ideales para compartir con toda tu familia.",
                85.00,
                R.drawable.dedosdequeso
            ),
            Food(
                "Aros de cebolla",
                "Nuestros aros de cebolla cortados gruesos se hacen con cebollas blancas enteras, empanizadas con una mezcla sutil de especias, que permiten que el dulzor natural de la cebolla se sienta. Se doran una vez que los pides y se salan apenas salen de la freidora. Estos se pueden acompañar con salsa de mostaza y miel o con algún adereso a tu elección.",
                75.00,
                R.drawable.arosdecebolla
            ),
            Food(
                "Papas a la francesa",
                "Se preparan cortándose en forma de bastones y friéndolas en aceite caliente hasta que queden doradas, crujientes para luego retirarlas del aceite y luego sazonarlas con sal.",
                70.00,
                R.drawable.papasalafrancesa
            ),
            Food(
                "Papas en gajo",
                "Las papas gajo se puede cocinar al horno o haciendo una fritura con aceite caliente, su nombre se deriva del corte que se le dan, precisamente como en cuartos haciendo alusión a unos gajos. Sazonaremos estas papas gajo con paprika, de tal manera que te chupes los dedos y repitas la porción de lo ricas que están.",
                80.00,
                R.drawable.papasgajo
            ),
            Food(
                "Salchipulpos",
                "Son salchichas cortadas desde la base de las mismas, en cruz hasta la mitad para simular los tentáculos del pulpo y de ahi freír en aceite hasta que se doren ligeramente. Finalmente, acompaña con las salsas y aderezos que prefieras",
                75.00,
                R.drawable.salchipulpos
            )
        )

    }
}