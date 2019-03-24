package de.goatfryed.pm.foxAndGeese.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Player 
{

   public static final String PROPERTY_name = "name";

   private String name;

   public String getName()
   {
      return name;
   }

   public Player setName(String value)
   {
      if (value == null ? this.name != null : ! value.equals(this.name))
      {
         String oldValue = this.name;
         this.name = value;
         firePropertyChange("name", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_foxOf = "foxOf";

   private Game foxOf = null;

   public Game getFoxOf()
   {
      return this.foxOf;
   }

   public Player setFoxOf(Game value)
   {
      if (this.foxOf != value)
      {
         Game oldValue = this.foxOf;
         if (this.foxOf != null)
         {
            this.foxOf = null;
            oldValue.setFox(null);
         }
         this.foxOf = value;
         if (value != null)
         {
            value.setFox(this);
         }
         firePropertyChange("foxOf", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_geeseOf = "geeseOf";

   private Game geeseOf = null;

   public Game getGeeseOf()
   {
      return this.geeseOf;
   }

   public Player setGeeseOf(Game value)
   {
      if (this.geeseOf != value)
      {
         Game oldValue = this.geeseOf;
         if (this.geeseOf != null)
         {
            this.geeseOf = null;
            oldValue.setGeese(null);
         }
         this.geeseOf = value;
         if (value != null)
         {
            value.setGeese(this);
         }
         firePropertyChange("geeseOf", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_currentPlayerOf = "currentPlayerOf";

   private Game currentPlayerOf = null;

   public Game getCurrentPlayerOf()
   {
      return this.currentPlayerOf;
   }

   public Player setCurrentPlayerOf(Game value)
   {
      if (this.currentPlayerOf != value)
      {
         Game oldValue = this.currentPlayerOf;
         if (this.currentPlayerOf != null)
         {
            this.currentPlayerOf = null;
            oldValue.setCurrentPlayer(null);
         }
         this.currentPlayerOf = value;
         if (value != null)
         {
            value.setCurrentPlayer(this);
         }
         firePropertyChange("currentPlayerOf", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_winnerOf = "winnerOf";

   private Game winnerOf = null;

   public Game getWinnerOf()
   {
      return this.winnerOf;
   }

   public Player setWinnerOf(Game value)
   {
      if (this.winnerOf != value)
      {
         Game oldValue = this.winnerOf;
         if (this.winnerOf != null)
         {
            this.winnerOf = null;
            oldValue.setWinner(null);
         }
         this.winnerOf = value;
         if (value != null)
         {
            value.setWinner(this);
         }
         firePropertyChange("winnerOf", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Meeple> EMPTY_meeples = new java.util.ArrayList<Meeple>()
   { @Override public boolean add(Meeple value){ throw new UnsupportedOperationException("No direct add! Use xy.withMeeples(obj)"); }};


   public static final String PROPERTY_meeples = "meeples";

   private java.util.ArrayList<Meeple> meeples = null;

   public java.util.ArrayList<Meeple> getMeeples()
   {
      if (this.meeples == null)
      {
         return EMPTY_meeples;
      }

      return this.meeples;
   }

   public Player withMeeples(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withMeeples(i);
            }
         }
         else if (item instanceof Meeple)
         {
            if (this.meeples == null)
            {
               this.meeples = new java.util.ArrayList<Meeple>();
            }
            if ( ! this.meeples.contains(item))
            {
               this.meeples.add((Meeple)item);
               ((Meeple)item).setPlayer(this);
               firePropertyChange("meeples", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutMeeples(Object... value)
   {
      if (this.meeples == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutMeeples(i);
            }
         }
         else if (item instanceof Meeple)
         {
            if (this.meeples.contains(item))
            {
               this.meeples.remove((Meeple)item);
               ((Meeple)item).setPlayer(null);
               firePropertyChange("meeples", item, null);
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

   @Override
   public String toString()
   {
      StringBuilder result = new StringBuilder();

      result.append(" ").append(this.getName());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setFoxOf(null);
      this.setGeeseOf(null);
      this.setCurrentPlayerOf(null);
      this.setWinnerOf(null);

      this.withoutMeeples(this.getMeeples().clone());


   }


}