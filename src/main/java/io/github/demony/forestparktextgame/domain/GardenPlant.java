package io.github.demony.forestparktextgame.domain;

import java.time.LocalDate;
import java.util.Objects;

public class GardenPlant {
    private final Long id;
    private Plant plant;
    private String description;
    private LocalDate artProcedureDate;
    private LocalDate plantedDate;
    private LocalDate removedDate;
    private boolean removed;

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GardenPlant that = (GardenPlant) o;
        return removed == that.removed && Objects.equals(id, that.id)
                && Objects.equals(plant, that.plant)
                && Objects.equals(description, that.description)
                && Objects.equals(artProcedureDate, that.artProcedureDate)
                && Objects.equals(plantedDate, that.plantedDate)
                && Objects.equals(removedDate, that.removedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, plant, description, artProcedureDate, plantedDate, removedDate, removed);
    }

    @Override
    public String toString() {
        return "GardenPlant{" +
                "id=" + id +
                ", plant=" + plant +
                ", description='" + description + '\'' +
                ", artProcedureDate=" + artProcedureDate +
                ", plantedDate=" + plantedDate +
                ", removedDate=" + removedDate +
                ", removed=" + removed +
                '}';
    }


    public Long getId() {
        return id;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getArtProcedureDate() {
        return artProcedureDate;
    }

    public void setArtProcedureDate(LocalDate artProcedureDate) {
        this.artProcedureDate = artProcedureDate;
    }

    public LocalDate getPlantedDate() {
        return plantedDate;
    }

    public void setPlantedDate(LocalDate plantedDate) {
        this.plantedDate = plantedDate;
    }

    public LocalDate getRemovedDate() {
        return removedDate;
    }

    public void setRemovedDate(LocalDate removedDate) {
        this.removedDate = removedDate;
    }

    public boolean isRemoved() {
        return removed;
    }

    public void setRemoved(boolean removed) {
        this.removed = removed;
    }

    public GardenPlant(Long id, Plant plant, String description,
                       LocalDate artProcedureDate,
                       LocalDate plantedDate,
                       LocalDate removedDate,
                       boolean removed) {
        this.id = id;
        this.plant = plant;
        this.description = description;
        this.artProcedureDate = artProcedureDate;
        this.plantedDate = plantedDate;
        this.removedDate = removedDate;
        this.removed = removed;
    }
}
