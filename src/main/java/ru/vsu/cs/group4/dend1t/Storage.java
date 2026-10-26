package ru.vsu.cs.group4.dend1t;

public class Storage {
    private Zone[] zones;

    public static class Zone {
        private Integer zoneId;
        private Bookcase[] bookcases;
    }

    public static class Bookcase {
        private Integer bookcaseId;
        private Shelf[] shelves;
        private Zone zone;
    }

    public static class Shelf {
        private Integer shelfId;
        private Cell[] cells;
        private Bookcase bookcase;
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
            Bookcase bc = shelf.bookcase;
            Zone zone = bc.zone;
            return zone.zoneId + " / " + bc.bookcaseId + " / " + shelf.shelfId + " / " + cellId;
        }

        public String getFullPath() {
            return fullPath;
        }
    }
}