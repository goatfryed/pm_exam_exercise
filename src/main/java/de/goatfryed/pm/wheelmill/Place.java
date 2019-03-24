package de.goatfryed.pm.wheelmill;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Place  
{



   public static final String PROPERTY_occupiedBy = "occupiedBy";

   private Stone occupiedBy = null;

   public Stone getOccupiedBy()
   {
      return this.occupiedBy;
   }

   public Place setOccupiedBy(Stone value)
   {
      if (this.occupiedBy != value)
      {
         Stone oldValue = this.occupiedBy;
         if (this.occupiedBy != null)
         {
            this.occupiedBy = null;
            oldValue.setOn(null);
         }
         this.occupiedBy = value;
         if (value != null)
         {
            value.setOn(this);
         }
         firePropertyChange("occupiedBy", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_CW = "CW";

   private Place CW = null;

   public Place getCW()
   {
      return this.CW;
   }

   public Place setCW(Place value)
   {
      if (this.CW != value)
      {
         Place oldValue = this.CW;
         if (this.CW != null)
         {
            this.CW = null;
            oldValue.setCCW(null);
         }
         this.CW = value;
         if (value != null)
         {
            value.setCCW(this);
         }
         firePropertyChange("CW", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_CCW = "CCW";

   private Place CCW = null;

   public Place getCCW()
   {
      return this.CCW;
   }

   public Place setCCW(Place value)
   {
      if (this.CCW != value)
      {
         Place oldValue = this.CCW;
         if (this.CCW != null)
         {
            this.CCW = null;
            oldValue.setCW(null);
         }
         this.CCW = value;
         if (value != null)
         {
            value.setCW(this);
         }
         firePropertyChange("CCW", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_onDiagonal = "onDiagonal";

   private Diagonal onDiagonal = null;

   public Diagonal getOnDiagonal()
   {
      return this.onDiagonal;
   }

   public Place setOnDiagonal(Diagonal value)
   {
      if (this.onDiagonal != value)
      {
         Diagonal oldValue = this.onDiagonal;
         if (this.onDiagonal != null)
         {
            this.onDiagonal = null;
            oldValue.withoutPlaces(this);
         }
         this.onDiagonal = value;
         if (value != null)
         {
            value.withPlaces(this);
         }
         firePropertyChange("onDiagonal", oldValue, value);
      }
      return this;
   }



   protected PropertyChangeSupport listeners = null;

   public boolean firePropertyChange(String propertyName, Object oldValue, Object newValue)
   {
      if (listeners != null)
      {
         listeners.firePropertyChange(propertyName, oldValue, newValue);
         return true;
      }
      return false;
   }

   public boolean addPropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(listener);
      return true;
   }

   public boolean addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
   {
      if (listeners == null)
      {
         listeners = new PropertyChangeSupport(this);
      }
      listeners.addPropertyChangeListener(propertyName, listener);
      return true;
   }

   public boolean removePropertyChangeListener(PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(listener);
      }
      return true;
   }

   public boolean removePropertyChangeListener(String propertyName,PropertyChangeListener listener)
   {
      if (listeners != null)
      {
         listeners.removePropertyChangeListener(propertyName, listener);
      }
      return true;
   }



   public void removeYou()
   {
      this.setCenterOf(null);
      this.setOccupiedBy(null);
      this.setCW(null);
      this.setCCW(null);
      this.setOnDiagonal(null);

   }












   public static final String PROPERTY_centerOf = "centerOf";

   private Game centerOf = null;

   public Game getCenterOf()
   {
      return this.centerOf;
   }

   public Place setCenterOf(Game value)
   {
      if (this.centerOf != value)
      {
         Game oldValue = this.centerOf;
         if (this.centerOf != null)
         {
            this.centerOf = null;
            oldValue.setCenter(null);
         }
         this.centerOf = value;
         if (value != null)
         {
            value.setCenter(this);
         }
         firePropertyChange("centerOf", oldValue, value);
      }
      return this;
   }









}