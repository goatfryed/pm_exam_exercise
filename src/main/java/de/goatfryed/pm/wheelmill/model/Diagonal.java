package de.goatfryed.pm.wheelmill.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Diagonal 
{

   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public Diagonal setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutDiagonals(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withDiagonals(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Place> EMPTY_places = new java.util.ArrayList<Place>()
   { @Override public boolean add(Place value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlaces(obj)"); }};


   public static final String PROPERTY_places = "places";

   private java.util.ArrayList<Place> places = null;

   public java.util.ArrayList<Place> getPlaces()
   {
      if (this.places == null)
      {
         return EMPTY_places;
      }

      return this.places;
   }

   public Diagonal withPlaces(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places == null)
            {
               this.places = new java.util.ArrayList<Place>();
            }
            if ( ! this.places.contains(item))
            {
               this.places.add((Place)item);
               ((Place)item).setOnDiagonal(this);
               firePropertyChange("places", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Diagonal withoutPlaces(Object... value)
   {
      if (this.places == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlaces(i);
            }
         }
         else if (item instanceof Place)
         {
            if (this.places.contains(item))
            {
               this.places.remove((Place)item);
               ((Place)item).setOnDiagonal(null);
               firePropertyChange("places", item, null);
            }
         }
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
      this.setGame(null);

      this.withoutPlaces(this.getPlaces().clone());


   }


}