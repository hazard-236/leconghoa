package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getCategory() { return category; }
    public float getCost() { return cost; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Media)) return false;
        Media other = (Media) obj;
        return this.title != null && this.title.equalsIgnoreCase(other.title);
    }
}

class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int titleDiff = m1.getTitle().compareToIgnoreCase(m2.getTitle());
        if (titleDiff != 0) return titleDiff;
        return Float.compare(m2.getCost(), m1.getCost());
    }
}

class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media m1, Media m2) {
        int costDiff = Float.compare(m2.getCost(), m1.getCost());
        if (costDiff != 0) return costDiff;
        return m1.getTitle().compareToIgnoreCase(m2.getTitle());
    }
}