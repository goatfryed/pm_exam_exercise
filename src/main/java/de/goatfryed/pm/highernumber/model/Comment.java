package de.goatfryed.pm.highernumber.model;

import java.beans.PropertyChangeSupport;

import java.beans.PropertyChangeListener;

public class Comment 
{

   public static final String PROPERTY_text = "text";

   private String text;

   public String getText()
   {
      return text;
   }

   public Comment setText(String value)
   {
      if (value == null ? this.text != null : ! value.equals(this.text))
      {
         String oldValue = this.text;
         this.text = value;
         firePropertyChange("text", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_date = "date";

   private String date;

   public String getDate()
   {
      return date;
   }

   public Comment setDate(String value)
   {
      if (value == null ? this.date != null : ! value.equals(this.date))
      {
         String oldValue = this.date;
         this.date = value;
         firePropertyChange("date", oldValue, value);
      }
      return this;
   }


   public static final String PROPERTY_author = "author";

   private Player author = null;

   public Player getAuthor()
   {
      return this.author;
   }

   public Comment setAuthor(Player value)
   {
      if (this.author != value)
      {
         Player oldValue = this.author;
         if (this.author != null)
         {
            this.author = null;
            oldValue.withoutComments(this);
         }
         this.author = value;
         if (value != null)
         {
            value.withComments(this);
         }
         firePropertyChange("author", oldValue, value);
      }
      return this;
   }



   public static final java.util.ArrayList<Player> EMPTY_recipients = new java.util.ArrayList<Player>()
   { @Override public boolean add(Player value){ throw new UnsupportedOperationException("No direct add! Use xy.withRecipients(obj)"); }};


   public static final String PROPERTY_recipients = "recipients";

   private java.util.ArrayList<Player> recipients = null;

   public java.util.ArrayList<Player> getRecipients()
   {
      if (this.recipients == null)
      {
         return EMPTY_recipients;
      }

      return this.recipients;
   }

   public Comment withRecipients(Object... value)
   {
      if(value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withRecipients(i);
            }
         }
         else if (item instanceof Player)
         {
            if (this.recipients == null)
            {
               this.recipients = new java.util.ArrayList<Player>();
            }
            if ( ! this.recipients.contains(item))
            {
               this.recipients.add((Player)item);
               ((Player)item).withReceived(this);
               firePropertyChange("recipients", null, item);
            }
         }
         else throw new IllegalArgumentException();
      }
      return this;
   }



   public Comment withoutRecipients(Object... value)
   {
      if (this.recipients == null || value==null) return this;
      for (Object item : value)
      {
         if (item == null) continue;
         if (item instanceof java.util.Collection)
         {
            for (Object i : (java.util.Collection) item)
            {
               this.withoutRecipients(i);
            }
         }
         else if (item instanceof Player)
         {
            if (this.recipients.contains(item))
            {
               this.recipients.remove((Player)item);
               ((Player)item).withoutReceived(this);
               firePropertyChange("recipients", item, null);
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

      result.append(" ").append(this.getText());
      result.append(" ").append(this.getDate());


      return result.substring(1);
   }

   public void removeYou()
   {
      this.setAuthor(null);

      this.withoutRecipients(this.getRecipients().clone());


   }


}