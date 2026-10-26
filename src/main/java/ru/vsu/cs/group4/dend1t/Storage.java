package ru.vsu.cs.group4.dend1t;

public class Storage {
    private Zone[] zones;

    public static class Zone {
        private Integer zoneId;
        private Сupboard[] сupboards;
    }

    public static class Сupboard {
        private Integer cupboardId;
        private Shelf[] shelves;
        private Zone zone;
    }

    public static class Shelf {
        private Integer shelfId;
        private Cell[] cells;
        private Сupboard сupboard;
    }

    public static class Cell {
        private final Integer cellId;
        private Shelf shelf;
        private String fullPath;

        public Cell(Integer cellId, Shelf shelf) {
            this.cellId = cellId;
            this.shelf = shelf;
            this.fullPath = generateFullPath();
        }
        public String generateFullPath() {
            Сupboard bc = shelf.сupboard;
            Zone zone = bc.zone;
            return zone.zoneId + " / " + bc.cupboardId + " / " + shelf.shelfId + " / " + cellId;
        }

        public String getFullPath() {
            return fullPath;
        }
    }
}