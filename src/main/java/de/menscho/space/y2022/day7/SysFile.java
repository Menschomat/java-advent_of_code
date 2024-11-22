package de.menscho.space.y2022.day7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SysFile {
    private final String name;
    private final boolean directory;
    private final List<SysFile> files;
    private long size = 0;
    private SysFile parent;

    public SysFile(String name, boolean directory) {
        this(name, directory, 0);
    }

    public SysFile(String name, boolean directory, long size) {
        this.name = name;
        this.directory = directory;
        this.files = directory ? new ArrayList<>() : null;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public boolean isDirectory() {
        return directory;
    }

    public boolean isFile() {
        return !isDirectory();
    }

    public List<SysFile> getFiles() {
        return files.stream().filter(SysFile::isFile).toList();
    }

    public List<SysFile> getDirs() {
        return files.stream().filter(SysFile::isDirectory).toList();
    }

    public SysFile getParent() {
        return parent;
    }

    public void add(SysFile aFile) {
        aFile.parent = this;
        files.add(aFile);
        addSize(aFile.size);
    }

    public void remove(SysFile aFile) {
        addSize(-aFile.size);
        aFile.parent = null;
        files.remove(aFile);
    }

    private void addSize(long size) {
        if (parent != null)
            parent.addSize(size);
        this.size += size;
    }

    public long getSize() {
        return size;
    }

    public Stream<SysFile> flatten() {
        // Combine the current node with the flattened stream of its children
        return Stream.concat(
                Stream.of(this), // Include the current node
                this.getDirs().stream().flatMap(SysFile::flatten) // Flatten children recursively
        );
    }
}
