This is an attempt to create a basic terminal/console like program written in Java that is extensible and reusable in other applications.  It should also be pluggable.

## Why? ##

Why am I doing this?

  1. To date I haven't found an easy to understand implementation of a console in Java or any other language that doesn't rely on kernel code or any other low-level libraries.
  1. It took ME a while to figure out how to do this reliably, because I didn't understand the basic model of a console program, and I wanted to help out the "next" guy. So here ya go next guy.

## News ##

11/30/2007
Today I uploaded the first finished code for this project. Currently I implement the following features:

  * Non editable text area
  * Basic command prompt (>)
  * Backspace
  * Keep track of last command in a buffer
  * Check for an empty current buffer
  * Ctrl+D exits the console (standard in Linux)

These features implement a basic console that provides basic console functionality minus the BIG features, which in my opinion are:

  1. Scripting
  1. Executing commands
  1. File and directory handling
  1. TCP/IP communications
  1. Piping
  1. Syntax checking

These are on the list, but I am implementing other generic features first.  See the "TODO" list below.

## TODO ##

  * Factor in a method to handle dictionary checking
  * Factor in a method to handle executable lines
  * Factor in environment identification methods
    * Getting and setting environment variables