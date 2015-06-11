package com.xyzcorp;

import java.util.Random;

import static com.google.common.base.Preconditions.checkNotNull;

public class Die {
    private final Random random;
    private final Integer pip;
    public static final int defaultPip = 1;

    public Die(Random random) {
        this(random, 1);
    }

    private Die(Random random, int pip) {
        checkNotNull(random, "A Random is required");
        this.random = random;
        this.pip = pip;
    }

    public int getPip() {
        return pip;
    }

    public Die roll() {
        return new Die(random, random.nextInt(6) + 1);
    }
}
