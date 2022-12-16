package Model.work;

import Model.workers;

import java.util.ArrayList;
import java.util.List;

public class Director{
    public List<String> Dir;

    public Director(List<String> dir) {
       this.Dir = dir;
        System.out.println(dir);
    }

    public List<String> getDir() {
        return Dir;
    }

    public void setDir(List<String> dir) {
        Dir = dir;
    }
}
