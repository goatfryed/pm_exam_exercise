package de.goatfryed.pm.wheelmill.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Game 
{

   public static final java.util.ArrayList<Player> EMPTY_players = new java.util.ArrayList<Player>()
   { @Override public boolean add(Player value){ throw new UnsupportedOperationException("No direct add! Use xy.withPlayers(obj)"); }};


   public static final String PROPERTY_players = "players";

   private java.util.ArrayList<Player> players = null;

   public java.util.ArrayList<Player> getPlayers()
   {
      if (this.players == null)
      {
         return EMPTY_players;
      }

      return this.players;
   }

   public Game withPlayers(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withPlayers(i);
            }
         }
         else if (item instanceof Player)
         {
            if (this.players == null)
            {
               this.players = new java.util.ArrayList<Player>();
            }
            if ( ! this.players.contains(item))
            {
               this.players.add((Player)item);
               ((Player)item).setGame(this);
               firePropertyChange("players", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Game withoutPlayers(Object... value)
   {
      if (this.players == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutPlayers(i);
            }
         }
         else if (item instanceof Player)
         {
            if (this.players.contains(item))
            {
               this.players.remove((Player)item);
               ((Player)item).setGame(null);
               firePropertyChange("players", item, null);
            }
         }
      }
      return this;
   }


   public static final String PROPERTY_currentPlayer = "currentPlayer";

   private Player currentPlayer = null;

   public Player getCurrentPlayer()
   {
      return this.currentPlayer;
   }

   public Game setCurrentPlayer(Player value)
   {
      if (this.currentPlayer != value)
      {
         Player oldValue = this.currentPlayer;
         if (this.currentPlayer != null)
         {
            this.currentPlayer = null;
            oldValue.setActive(null);
         }
         this.currentPlayer = value;
         if (value != null)
         {
            value.setActive(this);
         }
         firePropertyChange("currentPlayer", oldValue, value);
      }
      return this;
   }



   public static final String PROPERTY_winner = "winner";

   private Player winner = null;

   public Player getWinner()
   {
      return this.winner;
   }

   public Game setWinner(Player value)
   {
      if (this.winner != value)
      {
         Player oldValue = this.winner;
         if (this.winner != null)
         {
            this.winner = null;
            oldValue.setGameWon(null);
         }
         this.winner = value;
         if (value != null)
         {
            value.setGameWon(this);
         }
         firePropertyChange("winner", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Diagonal> EMPTY_diagonals = new java.util.ArrayList<Diagonal>()
   { @Override public boolean add(Diagonal value){ throw new UnsupportedOperationException("No direct add! Use xy.withDiagonals(obj)"); }};


   public static final String PROPERTY_diagonals = "diagonals";

   private java.util.ArrayList<Diagonal> diagonals = null;

   public java.util.ArrayList<Diagonal> getDiagonals()
   {
      if (this.diagonals == null)
      {
         return EMPTY_diagonals;
      }

      return this.diagonals;
   }

   public Game withDiagonals(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withDiagonals(i);
            }
         }
         else if (item instanceof Diagonal)
         {
            if (this.diagonals == null)
            {
               this.diagonals = new java.util.ArrayList<Diagonal>();
            }
            if ( ! this.diagonals.contains(item))
            {
               this.diagonals.add((Diagonal)item);
               ((Diagonal)item).setGame(this);
               firePropertyChange("diagonals", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Game withoutDiagonals(Object... value)
   {
      if (this.diagonals == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutDiagonals(i);
            }
         }
         else if (item instanceof Diagonal)
         {
            if (this.diagonals.contains(item))
            {
               this.diagonals.remove((Diagonal)item);
               ((Diagonal)item).setGame(null);
               firePropertyChange("diagonals", item, null);
            }
         }
      }
      return this;
   }


   public static final String PROPERTY_center = "center";

   private Place center = null;

   public Place getCenter()
   {
      return this.center;
   }

   public Game setCenter(Place value)
   {
      if (this.center != value)
      {
         Place oldValue = this.center;
         if (this.center != null)
         {
            this.center = null;
            oldValue.setCenterOf(null);
         }
         this.center = value;
         if (value != null)
         {
            value.setCenterOf(this);
         }
         firePropertyChange("center", oldValue, value);
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
      this.setCurrentPlayer(null);
      this.setWinner(null);
      this.setCenter(null);

      this.withoutPlayers(this.getPlayers().clone());


      this.withoutDiagonals(this.getDiagonals().clone());


   }


}