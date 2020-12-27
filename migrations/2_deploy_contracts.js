var TicTacToeContract = artifacts.require("../contracts/TicTacToe.sol");

module.exports = function(deployer) {
	deployer.deploy(TicTacToeContract);
};
