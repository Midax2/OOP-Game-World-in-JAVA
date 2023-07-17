package SourceFiles.Plants;
import SourceFiles.*;
import java.awt.*;
import java.util.Random;

public class Heracleum extends Plant {

    public Heracleum(World world) {
        this.world = world;
        initiative = 0;
        power = 10;
        Random random = new Random();
        do {
            X = random.nextInt(world.GetWidth()) + 1;
            Y = random.nextInt(world.GetHeight()) + 1;
        } while (world.GetElement(X, Y) != ' ');
        identity = 'M';
        name = "Heracleum";
        alive = true;
        generation = 1;
        color = new Color(50, 200, 100);
    }

    public Heracleum(World world, int X, int Y, int generation) {
        this.world = world;
        initiative = 0;
        power = 10;
        this.X = X;
        this.Y = Y;
        identity = 'M';
        name = "Heracleum";
        alive = true;
        this.generation = generation;
        color = new Color(50, 200, 100);
    }

    @Override
    public void Action() {
        if (world.GetType() == "Quad") {
            for (int i = GetY() - 1; i <= GetY() + 1; i++) {
                for (int j = GetX() - 1; j <= GetX() + 1; j++) {
                    Organism org = world.GetOrganism(GetMe(), j, i);
                    if (org != null && org.GetPower() > 0) {
                        org.SetAlive(false);
                        world.DeleteOrganism(org);
                    }
                }
            }
        }
        else {
            for (int i = 0; i < 6; i++) {
                int x = GetX() + dx[i];
                int y = GetY() + dy[i];
                Organism org = world.GetOrganism(GetMe(), x, y);
                if (org != null && org.GetPower() > 0) {
                    org.SetAlive(false);
                    world.DeleteOrganism(org);
                }
            }
        }
    }

    @Override
    public void Collision(Organism organism) {
        if (organism == null) {
            return;
        }
        organism.SetAlive(false);
        this.SetAlive(false);
        world.DeleteOrganism(GetMe());
        world.DeleteOrganism(organism);
        String message = organism.GetName() + " dead after eating Heracleum at X = " + X + ",Y = " + Y;
        world.AddMessage(message);
    }

    @Override
    public Organism NewBorn(int X, int Y) {
        return new Heracleum(world, X, Y, generation + 1);
    }

    @Override
    public boolean IsEatenDebuff(Organism organism) {
        return true;
    }
}
