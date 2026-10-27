package ru.vsu.cs.group4.dend1t;

public class Storage { //название уровней
    //Сохранение в файловую систему по папкам
    //Вспомогательные файлы
    private Zone[] zones;

    public class Zone {
        private Integer zoneId;
        private Cupboard[] сupboards;
    }

    public class Cupboard {
        private Integer cupboardId;
        private Shelf[] shelves;
        private Zone zone;
    }

    public class Shelf {
        private Integer shelfId;
        private Cell[] cells;
        private String name;
        private String decription;
        private Cupboard сupboard;
    }

    public class Cell {
        private final Integer cellId;
        private Shelf shelf;
        private String fullPath; //специальный класс
        private Boolean reserved;
        //массив потомков
        //ссылка на предков
        //древовидная структура
        public Cell(Integer cellId, Shelf shelf) {
            this.cellId = cellId;
            this.shelf = shelf;
            this.fullPath = generateFullPath();
        }
        public String generateFullPath() {
            Cupboard bc = shelf.сupboard;
            Zone zone = bc.zone;
            return zone.zoneId + " / " + bc.cupboardId + " / " + shelf.shelfId + " / " + cellId;
        }

        public String getFullPath() {
            return fullPath;
        }
    }
}