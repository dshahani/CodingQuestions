package tree;

public class AncestorDiffBrnch
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public static Node getAncestor(Node root, Node p, Node q)
	{

		if (!covers(root, p) || !covers(root, q))
		{
			return null;
		} else if (covers(p, q))
		{
			return p;
		} else if (covers(q, p))
		{
			return q;
		}

		boolean pOnLeft = covers(root.left, p);
		boolean qOnLeft = covers(root.left, q);

		if (pOnLeft ^ qOnLeft)
		{
			return root;
		}

		Node nextRoot = (pOnLeft ? root.left : root.right);
		return getAncestor(nextRoot, p, q);

	}

	public static boolean covers(Node p, Node q)
	{
		if (p == null || q == null)
		{
			return false;
		}

		if (p == q)
		{
			return true;
		}

		return covers(p.left, q) || covers(p.right, q);
	}
}
