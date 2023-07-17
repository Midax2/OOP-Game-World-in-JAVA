package SourceFiles.Plants;
import SourceFiles.*;
import java.util.Objects;
import java.util.Random;
public class Plant extends Organism {
    @Override
    public void Action() {
        Random random = new Random();
        int possibility = random.nextInt(9999) + 1;
        if (possibility % 36 == 0) {
            if (Objects.equals(world.GetType(), "Quad")) {
                int pos = random.nextInt(9);
                int count = 0;
                for (int i = GetX() - 1; i <= GetX() + 1; i++) {
                    for (int j = GetY() - 1; j <= GetY() + 1; j++) {
                        if (GetWorld().GetElement(i, j) == ' ' && count == pos) {
                            GetWorld().AddOrganism(NewBorn(i, j));
                            String message = "New " + GetName() + " was born at X = " + j + ", Y = " + i;
                            world.AddMessage(message);
                            return;
                        }
                        count++;
                    }
                }
            }
            else {
                int pos = random.nextInt(6);
                int count = 0;
                for (int i = 0; i < 6; i++) {
                    int tempX = GetX() + dx[i];
                    int tempY = GetY() + dy[i];
                    if (GetWorld().GetElement(tempX, tempY) == ' ' && count == pos) {
                        GetWorld().AddOrganism(NewBorn(tempX, tempY));
                        String message = "New " + GetName() + " was born at X = " + tempX + ", Y = " + tempY;
                        world.AddMessage(message);
                        return;
                    }
                    count++;
                }
            }
        }
    }

    @Override
    public void Collision(Organism organism) {
        if (organism == null)
            return;
        if (organism.IsEatenDebuff(GetMe())) {
            organism.Collision(GetMe());
            return;
        }
        if (GetPower() > organism.GetPower()) {
            organism.GetWorld().DeleteOrganism(organism);
            String message = organism.GetName() + " was killed by " + GetName() + " at X = " + GetX() + ", Y = " + GetY();
            organism.SetAlive(false);
            world.AddMessage(message);
        } else {
            GetWorld().DeleteOrganism(GetMe());
            String message = GetName() + " was killed by " + organism.GetName() + " at X = " + GetX() + ", Y = " + GetY();
            this.SetAlive(false);
            world.AddMessage(message);
        }
    }

    @Override
    public Organism NewBorn(int X, int Y){
        return null;
    };
}
