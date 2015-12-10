/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytetris;

/**
 *
 * @author Evgeny
 */

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Board extends JPanel {
    
    private final int TILE_WIDTH = 50;
    private final int TILE_HEIGHT = 50;
    private final int COLUMN_COUNT = 10;
    private final int ROW_COUNT = 15;
    private final int BOARD_WIDTH = TILE_WIDTH * COLUMN_COUNT;
    private final int BOARD_HEIGHT = TILE_HEIGHT * ROW_COUNT;
    public int CURRENT_ROW = 0;
    public int CURRENT_COLUMN = 5;
    private Tile blocks[][];
    public ArrayList<Tile> staticTiles;
    
    private Tetromino testFig = new Tetromino(Color.RED);
    
    public Tetromino currentTetromino;
    
    public Board() {
        
        blocks = new Tile[ROW_COUNT][COLUMN_COUNT];
        staticTiles = new ArrayList<>();
        /*for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                blocks[i][j] = new Tile(Color.BLACK);
            }
        }*/
        
        init();
    }
    
    private void init() {
        this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        this.setBackground(Color.BLACK);
    }
    
    @Override
    public void paintComponent(Graphics drawCanvas) {
        super.paintComponent(drawCanvas);
        
        Graphics copy = drawCanvas.create();
        Graphics2D g2d = (Graphics2D)copy;
        
        
        this.drawBoard(g2d);
        
        this.currentTetromino.draw(g2d, CURRENT_ROW, CURRENT_COLUMN, TILE_WIDTH, TILE_HEIGHT);
        this.drawGrid(g2d);
        
    }
    
    private void drawGrid(Graphics2D drawCanvas) {
        drawCanvas.setPaint(Color.LIGHT_GRAY);
        for (int i = 1; i < COLUMN_COUNT; i++) {
            drawCanvas.drawLine(i * TILE_WIDTH, 0, i * TILE_WIDTH, BOARD_HEIGHT);
        }

        for (int j = 1; j < ROW_COUNT; j++) {
            drawCanvas.drawLine(0, j * TILE_HEIGHT, BOARD_WIDTH, j * TILE_HEIGHT);
        }
    }
    
    private void drawBoard(Graphics2D drawCanvas) {
        for (Tile tempTile : staticTiles) {
            tempTile.draw(drawCanvas, TILE_WIDTH, TILE_HEIGHT);
        }
        /*for (int i = 0; i < ROW_COUNT; i++) {
            for (int j = 0; j < COLUMN_COUNT; j++) {
                drawCanvas.setPaint(blocks[i][j].getColor());
                drawCanvas.fillRect(j * TILE_WIDTH, i * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
            }
        }*/
    }
  

}