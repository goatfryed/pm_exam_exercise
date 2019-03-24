package de.goatfryed.pm.fourWins.model;

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



   public static final java.util.ArrayList<Column> EMPTY_columns = new java.util.ArrayList<Column>()
   { @Override public boolean add(Column value){ throw new UnsupportedOperationException("No direct add! Use xy.withColumns(obj)"); }};


   public static final String PROPERTY_columns = "columns";

   private java.util.ArrayList<Column> columns = null;

   public java.util.ArrayList<Column> getColumns()
   {
      if (this.columns == null)
      {
         return EMPTY_columns;
      }

      return this.columns;
   }

   public Game withColumns(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withColumns(i);
            }
         }
         else if (item instanceof Column)
         {
            if (this.columns == null)
            {
               this.columns = new java.util.ArrayList<Column>();
            }
            if ( ! this.columns.contains(item))
            {
               this.columns.add((Column)item);
               ((Column)item).setGame(this);
               firePropertyChange("columns", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Game withoutColumns(Object... value)
   {
      if (this.columns == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutColumns(i);
            }
         }
         else if (item instanceof Column)
         {
            if (this.columns.contains(item))
            {
               this.columns.remove((Column)item);
               ((Column)item).setGame(null);
               firePropertyChange("columns", item, null);
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
      this.setCurrentPlayer(null);
      this.setWinner(null);

      this.withoutPlayers(this.getPlayers().clone());


      this.withoutColumns(this.getColumns().clone());


   }


}