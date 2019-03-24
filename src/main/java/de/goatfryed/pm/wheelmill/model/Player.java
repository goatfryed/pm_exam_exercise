package de.goatfryed.pm.wheelmill.model;

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


   public static final String PROPERTY_color = "color";

   private String color;

   public String getColor()
   {
      return color;
   }

   public Player setColor(String value)
   {
      if (value == null ? this.color != null : ! value.equals(this.color))
      {
         String oldValue = this.color;
         this.color = value;
         firePropertyChange("color", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_game = "game";

   private Game game = null;

   public Game getGame()
   {
      return this.game;
   }

   public Player setGame(Game value)
   {
      if (this.game != value)
      {
         Game oldValue = this.game;
         if (this.game != null)
         {
            this.game = null;
            oldValue.withoutPlayers(this);
         }
         this.game = value;
         if (value != null)
         {
            value.withPlayers(this);
         }
         firePropertyChange("game", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_active = "active";

   private Game active = null;

   public Game getActive()
   {
      return this.active;
   }

   public Player setActive(Game value)
   {
      if (this.active != value)
      {
         Game oldValue = this.active;
         if (this.active != null)
         {
            this.active = null;
            oldValue.setCurrentPlayer(null);
         }
         this.active = value;
         if (value != null)
         {
            value.setCurrentPlayer(this);
         }
         firePropertyChange("active", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_gameWon = "gameWon";

   private Game gameWon = null;

   public Game getGameWon()
   {
      return this.gameWon;
   }

   public Player setGameWon(Game value)
   {
      if (this.gameWon != value)
      {
         Game oldValue = this.gameWon;
         if (this.gameWon != null)
         {
            this.gameWon = null;
            oldValue.setWinner(null);
         }
         this.gameWon = value;
         if (value != null)
         {
            value.setWinner(this);
         }
         firePropertyChange("gameWon", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Stone> EMPTY_stones = new java.util.ArrayList<Stone>()
   { @Override public boolean add(Stone value){ throw new UnsupportedOperationException("No direct add! Use xy.withStones(obj)"); }};


   public static final String PROPERTY_stones = "stones";

   private java.util.ArrayList<Stone> stones = null;

   public java.util.ArrayList<Stone> getStones()
   {
      if (this.stones == null)
      {
         return EMPTY_stones;
      }

      return this.stones;
   }

   public Player withStones(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withStones(i);
            }
         }
         else if (item instanceof Stone)
         {
            if (this.stones == null)
            {
               this.stones = new java.util.ArrayList<Stone>();
            }
            if ( ! this.stones.contains(item))
            {
               this.stones.add((Stone)item);
               ((Stone)item).setPlayer(this);
               firePropertyChange("stones", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Player withoutStones(Object... value)
   {
      if (this.stones == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutStones(i);
            }
         }
         else if (item instanceof Stone)
         {
            if (this.stones.contains(item))
            {
               this.stones.remove((Stone)item);
               ((Stone)item).setPlayer(null);
               firePropertyChange("stones", item, null);
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
      result.append(" ").append(this.getColor());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setGame(null);
      this.setActive(null);
      this.setGameWon(null);

      this.withoutStones(this.getStones().clone());


   }


}