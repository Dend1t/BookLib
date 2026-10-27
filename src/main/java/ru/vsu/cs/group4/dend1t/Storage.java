//массив потомков
        //ссылка на предков
        //древовидная структура
//Сохранение в файловую систему по папкам
    //Вспомогательные файлы
//         private String fullPath; - специальный класс
package ru.vsu.cs.group4.dend1t;

public class Storage<T> {

    public class Cell {
        private final Integer cellId;
        private String name;
        private String description;
        public T depot = null;
        private Boolean reserved;
        private Boolean lastCell;

        private Cell parent;
        private Cell firstChild;
        private Cell nextSibling;
        private Cell prevSibling;
        private Cell lastChild;
        private int childAmount;

        private String fullPath;

        public Cell(Integer cellId, String name, String description) {
            this.cellId = cellId;
            this.name = name;
            this.description = description;
            this.fullPath = generateFullPath();
        }

        public Cell(Integer cellId, String name, Boolean reserved) {
            this.cellId = cellId;
            this.name = name;
            this.reserved = reserved;
            this.lastCell = true;
            this.fullPath = generateFullPath();
        }

        public void addChildLast(Cell child) {
            addChildAt(childAmount, child);
        }
        public void addChildFirst(Cell child) {
            addChildAt(0, child);
        }

        public void addChildAt(int index, Cell child) {
            if (index < 0 || index > childAmount) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + childAmount);
            }

            child.parent = this;
            child.fullPath = child.generateFullPath();

            if (childAmount == 0) {
                child.prevSibling = null;
                child.nextSibling = null;
                this.firstChild = child;
                this.lastChild = child;
            } else if (index == 0) {
                child.prevSibling = null;
                child.nextSibling = this.firstChild;
                this.firstChild.prevSibling = child;
                this.firstChild = child;
            } else if (index == childAmount) {
                child.prevSibling = this.lastChild;
                child.nextSibling = null;
                this.lastChild.nextSibling = child;
                this.lastChild = child;
            } else {
                Cell current = getChildAt(index);
                Cell prev = current.prevSibling;

                child.prevSibling = prev;
                child.nextSibling = current;

                prev.nextSibling = child;
                current.prevSibling = child;
            }

            childAmount++;
        }

        public Cell getChildAt(int index) {
            if (index < 0 || index >= childAmount) {
                return null;
            }

            Cell current;
            if (index < childAmount / 2) {
                current = this.firstChild;
                for (int i = 0; i < index; i++) {
                    current = current.nextSibling;
                }
            } else {
                current = this.lastChild;
                for (int i = childAmount - 1; i > index; i--) {
                    current = current.prevSibling;
                }
            }
            return current;
        }

        public String generateFullPath() {
            if (parent == null) {
                return String.valueOf(cellId);
            }
            return parent.generateFullPath() + " / " + cellId;
        }

        public void place(T thing){
            depot = thing;
            this.reserved = true;
        }
    }
}