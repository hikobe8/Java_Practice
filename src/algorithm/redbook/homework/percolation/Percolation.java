package algorithm.redbook.homework.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int N;
    //top bottom
    private final WeightedQuickUnionUF ufWithBottom;
    //just top
    private final WeightedQuickUnionUF uf;

    //0 closed 1 open
    private final byte[] site;

    private int openCount = 0;

    private final int top;
    private final int bottom;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("invalid n = " + n);
        }
        N = n;
        ufWithBottom = new WeightedQuickUnionUF(n * n + 2);
        uf = new WeightedQuickUnionUF(n * n + 2);
        site = new byte[n * n];
        top = n * n;
        bottom = n * n + 1;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (isOpen(row, col)) {
            return;
        }
        int currentSiteIndex = convert2DCoordTo1D(row, col);
        site[currentSiteIndex] = 1;
        openCount++;
        //union site with top
        if (row == 1 && connected(currentSiteIndex, top)) {
            uf.union(currentSiteIndex, top);
            ufWithBottom.union(currentSiteIndex, top);
        }
        //union site with bottom
        if (row == N && connected(currentSiteIndex, bottom)) {
            ufWithBottom.union(currentSiteIndex, bottom);
        }

        //union the above site(if opened) of current site
        if (row > 1) {
            if (isOpen(row - 1, col)) {
                ufWithBottom.union(currentSiteIndex, convert2DCoordTo1D(row - 1, col));
                uf.union(currentSiteIndex, convert2DCoordTo1D(row - 1, col));
            }
        }

        //union the bottom site(if opened) of current site
        if (row < N) {
            if (isOpen(row + 1, col)) {
                ufWithBottom.union(currentSiteIndex, convert2DCoordTo1D(row + 1, col));
                uf.union(currentSiteIndex, convert2DCoordTo1D(row + 1, col));
            }
        }

        //union the left site(if opened) of current site
        if (col > 1) {
            if (isOpen(row, col - 1)) {
                ufWithBottom.union(currentSiteIndex, convert2DCoordTo1D(row, col - 1));
                uf.union(currentSiteIndex, convert2DCoordTo1D(row, col - 1));
            }
        }

        //union the right site(if opened) of current site
        if (col < N) {
            if (isOpen(row, col + 1)) {
                ufWithBottom.union(currentSiteIndex, convert2DCoordTo1D(row, col + 1));
                uf.union(currentSiteIndex, convert2DCoordTo1D(row, col + 1));
            }
        }

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        int index = convert2DCoordTo1D(row, col);
        return site[index] == 1;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int index = convert2DCoordTo1D(row, col);
        return uf.find(top) == uf.find(index);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return ufWithBottom.find(top) == ufWithBottom.find(bottom);
    }

    private void validate(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new IllegalArgumentException("invalid (row, col) = (" + row + ", " + col + ").");
    }

    //convert (row, col) to (index)
    private int convert2DCoordTo1D(int row, int col) {
        validate(row, col);
        return (row - 1) * N + col - 1;
    }

    //is connected in ufWithBottom
    private boolean connected(int p, int q) {
        return ufWithBottom.find(p) != ufWithBottom.find(q);
    }

    // test client (optional)
    public static void main(String[] args) {
        Percolation percolation = new Percolation(10);
        percolation.open(1, 5);
        percolation.open(1, 6);
        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.showSites();
        System.out.println(percolation.percolates());
        percolation.open(3, 5);
        percolation.open(4, 5);
        percolation.open(5, 5);
        percolation.showSites();
        System.out.println(percolation.percolates());
        percolation.open(5, 6);
        percolation.open(5, 7);
        percolation.open(6, 7);
        percolation.showSites();
        System.out.println(percolation.percolates());
        percolation.open(7, 7);
        percolation.open(7, 6);
        percolation.open(8, 6);
        percolation.open(8, 5);
        percolation.open(9, 5);
        percolation.open(10, 2);
        percolation.open(9, 4);
        percolation.open(10, 4);
        percolation.showSites();
        System.out.println(percolation.isFull(10, 2));
        System.out.println(percolation.isFull(10, 4));
        System.out.println(percolation.percolates());
    }

    private void showSites(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    System.out.print(site[i*N + j] + " ");
                } else {
                    System.out.print(site[i*N + j] + "\n");
                }
            }
        }
    }

}
