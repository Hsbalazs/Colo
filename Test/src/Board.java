import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Board extends JComponent {
    private Area area;
    private final int tileSize;
    public Board() {
        this.area = new Area();
        tileSize = 36;
        setPreferredSize(new Dimension(tileSize * 10, tileSize * 10 + 40));
        setVisible(true);
    }
    public void drawStatistics(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 360, 360, 40);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 16));
        graphics.drawString("Level " + area.areaCurrentLevel + "  ", 20, 385);
    }

    public void drawBackground(Graphics g) {
        g.setColor(Color.BLACK);
        //g.setStroke(new BasicStroke(10));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                g.drawRect(i * 40, j * 40, 40, 40);
        }
        g.setColor(Color.BLUE);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                g.drawRect(i * 120, j * 120, 120, 120);
        }
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        //Graphics2D g2d = (Graphics2D) graphics;

    //    drawTiles(graphics);
    //    drawEnemy(graphics);
    //    drawHero(graphics);
        drawStatistics(graphics);
        drawBackground(graphics);
    }
/*
    private void drawTiles(Graphics graphics) {
        Tile[][] tiles = area.getTiles(area.areaCurrentLevel);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                String image = tiles[j][i] instanceof Wall ? "img/wall.png" : "img/floor.png";
                /*
                Ternary operator (condition ? doIfTrue : else)  is the same as:
                if (tiles[j][i] instanceof Floor) {
                    image = "img/floor.png";
                } else {
                    image = "img/wall.png";
                }
                 */
           /*     new PositionedImage(image, i * tileSize, j * tileSize).draw(graphics);
            }
        }
    }

    private void drawEnemy(Graphics graphics) {
        Tile[][] tiles = area.getTiles(area.areaCurrentLevel);
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                String image = "";
                if (tiles[j][i] instanceof Boss) {
                    image = "img/boss.png";
                } else if (tiles[j][i] instanceof Skeleton) {
                    image = "img/skeleton.png";
                }
                new PositionedImage(image, i * tileSize, j * tileSize).draw(graphics);
            }
        }
    }

    private void drawHero(Graphics graphics) {
        String heroImagePath = "";
        if (hero.getDirection() == Direction.UP) {
            heroImagePath = "img/hero-up.png";
        } else if (hero.getDirection() == Direction.DOWN) {
            heroImagePath = "img/hero-down.png";
        } else if (hero.getDirection() == Direction.LEFT) {
            heroImagePath = "img/hero-left.png";
        } else if (hero.getDirection() == Direction.RIGHT) {
            heroImagePath = "img/hero-right.png";
        }

        PositionedImage heroImage = new PositionedImage(heroImagePath, hero.getX() * tileSize, hero.getY() * tileSize);
        heroImage.draw(graphics);
    }

    private void drawStatistics(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 720, 720, 40);
        graphics.setColor(Color.BLACK);
        graphics.setFont(new Font("Arial", Font.BOLD, 16));
        graphics.drawString("Hero (Level " + hero.getLevel() + " ) HP: " + hero.getHealthPoint() + "/" + hero.healthPointMax + " | DP: " + hero.getDefendPoint() + " | SP: " + hero.getStrikePoint(), 20, 745);
        if(area.getTile(hero.getY(), hero.getX()) instanceof Character) {
            int enemySerialNumberInTheEnemiesList = 0;
            for (int i = 0; i < area.Enemies.size(); i++) {
                if(area.Enemies.get(i).getX() == hero.getX() && area.Enemies.get(i).getY() == hero.getY()) {
                    enemySerialNumberInTheEnemiesList = i;
                }
            }
            Character enemySamePlace = area.Enemies.get(enemySerialNumberInTheEnemiesList);
            graphics.drawString("Enemy (Level " + enemySamePlace.level + " ) HP: " + enemySamePlace.getHealthPoint() + " | DP: " + enemySamePlace.getDefendPoint() + " | SP: " + enemySamePlace.getStrikePoint() + "Key? " + enemySamePlace.getKey(), 360, 745);
        }
    }*/
}