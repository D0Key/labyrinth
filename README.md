Klasse ExampleMaze
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package de.uniwue.gdp.labyrinth.examples;

import de.uniwue.gdp.labyrinth.model.Maze;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public final class ExampleMaze implements Maze {
    private final BitSet z;
    private final Map<Integer, ExampleMaze.M> a;
    private final int i;
    private int o;
    private int r;

    public ExampleMaze(char[] z, int i1) {
        this.i = i1;
        this.z = new BitSet(z.length);

        for(int i = 0; i < z.length; ++i) {
            this.z.set(i, z[i] == '#');
        }

        this.a = new HashMap();
        this.o = i1 + 1;
        this.r = 3;
    }

    private int i(int r) {
        switch(this.r(r) + 1) {
        case 1:
            return this.o - 1;
        case 2:
            return this.o - this.i;
        case 3:
            return this.o + 1;
        case 4:
            return this.o + this.i;
        default:
            throw new IllegalStateException();
        }
    }

    private int r(int o) {
        return (3 + this.r + o) % 4;
    }

    public boolean isWall(int direction) {
        return this.z.get(this.i(direction));
    }

    public void mark(int direction) {
        ((ExampleMaze.M)this.a.computeIfAbsent(this.o, (i) -> {
            return new ExampleMaze.M();
        })).mark(this.r(direction));
    }

    public int marks(int direction) {
        return (Integer)Optional.ofNullable(this.a.get(this.o)).map((mark) -> {
            return mark.get(this.r(direction));
        }).orElse(0);
    }

    public void walk(int direction) {
        if (this.isWall(direction)) {
            throw new IllegalArgumentException("You can't walk through walls");
        } else {
            this.o = this.i(direction);
            this.r = this.r(direction);
        }
    }

    public int width() {
        return this.i;
    }

    public int height() {
        return this.z.length() / this.i;
    }

    private static final class M {
        private final int[] k;

        private M() {
            this.k = new int[4];
        }

        private int get(int i) {
            return this.k[i];
        }

        private void mark(int i) {
            int var10002 = this.k[i]++;
        }
    }
}




Klasse Examples


package de.uniwue.gdp.labyrinth.examples;

import de.uniwue.gdp.labyrinth.model.Maze;

public class Examples {
    private static final int EXAMPLE01_WIDTH = 13;
    private static final String EXAMPLE01 = "##############           ## ############ # #       ## # # ##### ## #   #   # ## ### # # # ##   # # # # #### # # # # ##   #     # #### ####### ##           ##############";
    private static final int EXAMPLE02_WIDTH = 31;
    private static final String EXAMPLE02 = "################################                             ## ########################### ## # #             #         # ## # # ##### ### # # # ##### # ## # # #   # #   # # #     # # ## #   # # # # ### # ##### # # ## ### # # # #   #   #     # # ##   # # # # ######### ### # # #### # # # # #     #   #   # # ##   # # # # #       ### ### # #### #     # #     #   #     # ## # ####### ################# ## #                 #       # ## # ####### ####### # ##### # ## #       #       # # #     # ## ####### ####### # # # ##### ##         #       # #         ## ######### ####### ######### ##         #                   ################################";

    public Examples() {
    }

    public static Maze example01() {
        return new ExampleMaze("##############           ## ############ # #       ## # # ##### ## #   #   # ## ### # # # ##   # # # # #### # # # # ##   #     # #### ####### ##           ##############".toCharArray(), 13);
    }

    public static Maze example02() {
        return new ExampleMaze("################################                             ## ########################### ## # #             #         # ## # # ##### ### # # # ##### # ## # # #   # #   # # #     # # ## #   # # # # ### # ##### # # ## ### # # # #   #   #     # # ##   # # # # ######### ### # # #### # # # # #     #   #   # # ##   # # # # #       ### ### # #### #     # #     #   #     # ## # ####### ################# ## #                 #       # ## # ####### ####### # ##### # ## #       #       # # #     # ## ####### ####### # # # ##### ##         #       # #         ## ######### ####### ######### ##         #                   ################################".toCharArray(), 31);
    }
}



