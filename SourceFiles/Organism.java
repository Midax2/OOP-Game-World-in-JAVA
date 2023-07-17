package SourceFiles;

import java.awt.*;

public abstract class Organism {
    protected Color color;
    protected char identity;
    protected String name;
    protected int power;
    protected int initiative;
    protected int generation;
    protected int X, Y;
    protected boolean alive;
    protected int prev_X, prev_Y;
    protected World world;
    protected final int[] dx = { -1, -1, 0, 1, 1, 0 };
    protected final int[] dy = { -1, 0, 1, 1, 0, -1 };
    public abstract void Action();
    public abstract void Collision(Organism organism);
    public abstract Organism NewBorn(int X, int Y);

    public World GetWorld() {
        return world;
    }

    public Organism GetMe() {
        return this;
    }

    public Color GetColor() {
        return color;
    }

    public boolean GetAlive() {
        return alive;
    }
    public void SetAlive(boolean alive){
        this.alive = alive;
    }

    public int GetInitiative() {
        return initiative;
    }

    public int GetPower() {
        return power;
    }

    public void SetPower(int power) {
        this.power = power;
    }

    public int GetX() {
        return X;
    }

    public int GetY() {
        return Y;
    }

    public void SetX(int X) {
        this.X = X;
    }

    public void SetY(int Y) {
        this.Y = Y;
    }

    public int GetPrevX() {
        return prev_X;
    }

    public int GetPrevY() {
        return prev_Y;
    }

    public void SetPrevX(int X) {
        this.prev_X = X;
    }

    public void SetPrevY(int Y) {
        this.prev_Y = Y;
    }

    public char GetIdentity() {
        return identity;
    }

    public int GetGeneration() {
        return generation;
    }

    public String GetName() {
        return name;
    }

    public boolean Defend(Organism organism) {
        return false;
    }

    public boolean RunAway(Organism organism) {
        return false;
    }

    public boolean IsEatenDebuff(Organism organism) {
        return false;
    }

    public void Print() {
        world.SetOrganismOnPoint(GetX(), GetY(), GetIdentity());
    }
}