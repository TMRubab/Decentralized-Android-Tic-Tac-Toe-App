# Decentralized-Tic-Tac-Toe-Game
This is a decentralized online two player Tic-Tac-Toe game. Users can create account, log in, create or join a game, play game, and save statistics. Please note that the specific rules of the game is not provided. The contract just manages the accounts and communication between players (i.e. moves during game). So, it can be used to play any n by n turn-based board game.

To run this game, you need to use truffle and ganache. From ganache, you can use an account to deploy the contract to a private network. Then you can use truffle console to play the game. Since this is a two player game, you need to open two terminal and use truffle console in both of them. Don't forget to edit truffle-config.js to set the proper account address taken from ganache.
