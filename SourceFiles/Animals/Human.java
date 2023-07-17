package SourceFiles.Animals;
import SourceFiles.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Human extends Animal {
    private Turn turn;
    private int HexX, HexY;
    private boolean superPower;
    private int superPowerEndRound = -1;
    public Human(World world) {
        this.world = world;
        initiative = 4;
        power = 5;
        turn = Turn.NONE;
        superPower = false;
        Random random = new Random();
        do {
            int x = random.nextInt(world.GetWidth()) + 1;
            int y = random.nextInt(world.GetHeight()) + 1;
            if (world.GetElement(x, y) == ' ') {
                X = x;
                Y = y;
                break;
            }
        } while (true);
        HexX = X;
        HexY = Y;
        identity = 'H';
        name = "Human";
        alive = true;
        generation = 1;
        color = new Color(255, 0, 0);
    }

    public Human(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 4;
        power = 5;
        this.X = X;
        this.Y = Y;
        HexX = X;
        HexY = Y;
        turn = Turn.NONE;
        superPower = false;
        identity = 'H';
        name = "Human";
        alive = true;
        this.generation = generation;
        color = new Color(255, 0, 0);
    }

    @Override
    public void Action() {
        SetPrevX(GetX());
        SetPrevY(GetY());
        GetWorld().SetOrganismOnPoint(GetX(), GetY(), ' ');
        if (Objects.equals(world.GetType(), "Quad")) {
            switch (turn) {
                case LEFT -> {
                    if (GetX() - 1 >= 1) SetX(GetX() - 1);
                }
                case UP -> {
                    if (GetY() - 1 >= 1) SetY(GetY() - 1);
                }
                case RIGHT -> {
                    if (GetX() + 1 <= GetWorld().GetWidth()) SetX(GetX() + 1);
                }
                case DOWN -> {
                    if (GetY() + 1 <= GetWorld().GetHeight()) SetY(GetY() + 1);
                }
            }
        }
        else {
            SetX(GetHexX());
            SetY(GetHexY());
        }
    }

    @Override
    public void Collision(Organism organism) {
        if (superPower && world.GetRound() <= superPowerEndRound) {
            power += 5;
            superPower = false;
            super.Collision(organism);
            return;
        }
        if (world.GetRound() <= superPowerEndRound) {
            power--;
        }
        super.Collision(organism);
    }

    public void SetTurn(Turn turn) {
        this.turn = turn;
    }
    public Turn GetTurn() {
        return turn;
    }
    public void SetHexX(int X) {
        this.HexX = X;
    }
    public int GetHexX() {
        return HexX;
    }
    public void SetHexY(int Y) {
        this.HexY = Y;
    }
    public int GetHexY() {
        return HexY;
    }

    public void ChangeSuperPower() {
        if (!superPower && world.GetRound() > superPowerEndRound) {
            superPower = true;
            superPowerEndRound = world.GetRound() + 5;
        }
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Human(world, X, Y, generation + 1);
    }

    public boolean GetSuperPower() {
        return superPower;
    }

    public void SetSuperPower(boolean power) {
        superPower = power;
    }
    public int GetEndRound() {
        return superPowerEndRound;
    }
    public void SetEndRound(int endRound) {
        superPowerEndRound = endRound;
    }
}
