package javas;

import java.io.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class Du {

    private final boolean humanReadable;
    private final boolean totalSize;
    private final boolean divider;

    public Du(boolean humanReadable, boolean totalSize, boolean divider) {
        this.humanReadable = humanReadable;
        this.totalSize = totalSize;
        this.divider = divider;
    }

    public String du(List<String> fileName) {
        try {
            if (totalSize) {
                long res = 0;
                for (String name : fileName) {
                    res += fileSize(name);
                }
                System.out.println(TotalSize(res));
            } else {
                for (String name : fileName) {
                    System.out.println(TotalSize(fileSize(name)));
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Файла нет");
        }
        return "";
    }

    public long fileSize(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) throw new IllegalArgumentException();
        return FileUtils.sizeOf(file);
    }

    public String TotalSize(long fileSize) {
        if (humanReadable) {
            List<String> nameRaz = new ArrayList(Arrays.asList("B", "KB", "MB", "GB"));
            long size = fileSize;
            int i = 0;
            while (size > Divider() - 1) {
                size = size / Divider();
                i += 1;
            }
            if (i >= 4) return "Больше TB";
            return "" + size + " " + nameRaz.get(i);
        } else {
            return "" + fileSize / Divider();
        }
    }

    public int Divider() {
        int Den;
        if (divider) Den = 1000;
        else Den = 1024;
        return Den;
    }

}

