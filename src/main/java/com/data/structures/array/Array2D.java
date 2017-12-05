package com.data.structures.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Array2D<T> implements Iterable<T> {

    private static final Logger log = LoggerFactory.getLogger(Array2D.class);

    private T[][] masterArray;

    public Array2D(T[][] values) {
        this.masterArray = values;
    }

    public T get(int i, int j) {
        return this.masterArray[i][j];
    }

    public void set(int i, int j, T value) {
        this.masterArray[i][j] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Array2DIterator<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    class Array2DIterator<T> implements Iterator<T> {

        private int currentI = 0;
        private int currentJ = 0;

        /**
         * Check if the updated I & J has a viable value
         * @return
         */
        private boolean hasNextJ() {
            return currentJ < Array2D.this.masterArray[currentI].length;
        }

        private boolean hasNextI() {
            return currentI < Array2D.this.masterArray.length;
        }

        /**
         * Increment I to the position of the next array
         */
        private void nextI() {
            currentI++;
            if (currentI == Array2D.this.masterArray.length) {
                return;
            }
            if (Array2D.this.masterArray[currentI].length == 0) {
                this.nextI();
            }
        }

        /**
         * Increment I and J to the next viable position
         */
        private void nextIJ() {
            currentJ++;
            if (currentJ == Array2D.this.masterArray[currentI].length) {
                currentJ = 0;
                this.nextI();
            }
        }

        @Override
        public boolean hasNext() {
            return this.hasNextI() && this.hasNextJ();
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            try {
                return (T) Array2D.this.get(currentI, currentJ);
            } finally {
                this.nextIJ();
            }
        }

        @Override
        public void remove() {
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
        }
    }
}
