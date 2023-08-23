package finaltask;
/**
 *  @apiNote
 Необходимо превратить собранное на семинаре дерево поиска в полноценное левостороннее красно-черное дерево. И реализовать в нем метод добавления новых элементов с балансировкой.

 Красно-черное дерево имеет следующие критерии:
 • Каждая нода имеет цвет (красный или черный)
 • Корень дерева всегда черный
 • Новая нода всегда красная
 • Красные ноды могут быть только левым ребенком
 • У краной ноды все дети черного цвета

 Соответственно, чтобы данные условия выполнялись, после добавления
 элемента в дерево необходимо произвести балансировку, благодаря которой все критерии выше
 станут валидными. Для балансировки существует 3 операции – левый малый поворот,
 правый малый поворот и смена цвета.
 */

public class Tree {


	private Node root;

/**
 * балансировка левым поворотом
* */
	private Node leftSwap(Node node) {
		Node leftChild = node.leftChild;
		Node between = node.leftChild.rightChild;
		leftChild.rightChild = node;
		node.leftChild = between;
		leftChild.color = node.color;
		node.color = Color.RED;
		return leftChild;
	}

	/**
	 * балансировка правым поворотом
	 * */
	private Node rightSwap(Node node) {
		Node rightChild = node.rightChild;
		Node betweenChild = node.rightChild.leftChild;
		rightChild.leftChild = node;
		node.rightChild = betweenChild;
		rightChild.color = node.color;
		node.color = Color.RED;
		return rightChild;
	}

	/**
	 * смена цвета
	 * */
	private void colorSwap(Node node) {
		node.rightChild.color = Color.BLACK;
		node.leftChild.color = Color.BLACK;
		node.color = Color.RED;
	}

	public boolean add(int key) {
		if (root != null) {
			boolean result = addNode(root, key);
			root = balanced(root);
			root.color = Color.BLACK;
			return result;
		} else {
			root = new Node();
			root.color = Color.BLACK;
			root.key = key;
			return true;
		}
	}

	private boolean addNode(Node node, int key) {
		if (key == node.key) {
			return false;
		} else {
			if (key < node.key) {
				if (node.leftChild != null) {
					boolean result = addNode(node.leftChild, key);
					node.leftChild = balanced(node.leftChild);
					return result;
				} else {
					node.leftChild = new Node();
					node.leftChild.color = Color.RED;
					node.leftChild.key = key;
					return true;
				}
			} else {
				if (node.rightChild != null) {
					boolean result = addNode(node.rightChild, key);
					node.rightChild = balanced(node.rightChild);
					return result;
				} else {
					node.rightChild = new Node();
					node.rightChild.color = Color.RED;
					node.rightChild.key = key;
					return true;
				}

			}
		}
	}

/**
 * балансировка
 * */
	private Node balanced(Node node) {
		Node result = node;
		boolean needBalance;
		do {
			needBalance = false;
			if (result.rightChild != null && result.rightChild.color == Color.RED
					&& (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
				needBalance = true;
				result = rightSwap(result);
			}
			if (result.leftChild != null && result.leftChild.color == Color.RED && result.leftChild.leftChild != null
					&& result.leftChild.leftChild.color == Color.RED) {
				needBalance = true;
				result = leftSwap(result);
			}
			if (result.leftChild != null && result.leftChild.color == Color.RED && result.rightChild != null
					&& result.rightChild.color == Color.RED) {
				needBalance = true;
				colorSwap(result);
			}
		} while (needBalance);
		return result;
	}


	private void printTree(Node node) {
		if (node.leftChild != null) {
			printTree(node.leftChild);
		}
		System.out.print(node.key + " ");
		if (node.rightChild != null) {
			printTree(node.rightChild);
		}
	}

	public void printTree() {
		printTree(root);
	}

	private static class Node {
		int key;
		Node leftChild;
		Node rightChild;
		Color color;
	}

	enum Color {
		RED, BLACK
	}
}