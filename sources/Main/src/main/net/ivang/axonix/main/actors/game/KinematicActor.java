/*
 * Copyright 2012-2013 Ivan Gadzhega
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package net.ivang.axonix.main.actors.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * @author Ivan Gadzhega
 * @since 0.3
 */
public class KinematicActor extends Actor {

    protected float speed;
    protected Vector2 direction;

    public KinematicActor() {
        this.speed = 0;
        this.direction = new Vector2(0, 0);
    }

    public KinematicActor(float speed, Vector2 direction) {
        this.speed = speed;
        this.direction = direction;
    }

    //---------------------------------------------------------------------
    // Getters & Setters
    //---------------------------------------------------------------------

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public Vector2 getDirection() {
        return direction;
    }

    public void setDirection(Vector2 direction) {
        this.direction.x = direction.x;
        this.direction.y = direction.y;
    }

    //---------------------------------------------------------------------
    // Nested Classes
    //---------------------------------------------------------------------

    public static class Direction {

        public static final Vector2 IDLE = new Vector2(0, 0);
        public static final Vector2 UP = new Vector2(0, 1);
        public static final Vector2 RIGHT = new Vector2(1, 0);
        public static final Vector2 DOWN = new Vector2(0, -1);
        public static final Vector2 LEFT = new Vector2(-1, 0);

        public static final Vector2 UP_RIGHT = new Vector2(1, 1).nor();
        public static final Vector2 UP_LEFT = new Vector2(-1, 1).nor();
        public static final Vector2 DOWN_RIGHT = new Vector2(1, -1).nor();
        public static final Vector2 DOWN_LEFT = new Vector2(-1, -1).nor();

        private static final Vector2[] ORTHOGONALS = new Vector2[] {RIGHT, DOWN, LEFT, UP};
        private static final Vector2[] DIAGONALS = new Vector2[] {UP_RIGHT, UP_LEFT, DOWN_RIGHT, DOWN_LEFT};

        public static Vector2 getRandomOrthogonal() {
            return ORTHOGONALS[(MathUtils.random(ORTHOGONALS.length - 1))];
        }

        public static Vector2 getRandomDiagonal() {
            return DIAGONALS[(MathUtils.random(DIAGONALS.length - 1))];
        }

    }

}
