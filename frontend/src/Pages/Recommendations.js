import React, { useState } from 'react';
import clsx from 'clsx';
import { v4 as uuid } from 'uuid';
import PropTypes from 'prop-types';
import {
  Box,
  Card,
  CardHeader,
  Divider,
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  makeStyles,
} from '@material-ui/core';
import MoreHorizIcon from '@material-ui/icons/MoreHoriz';
import Pagination from '@material-ui/lab/Pagination';
import IconButton from '@material-ui/core/IconButton';

const data = [
  {
    engines: [
      {
        id: uuid(),
        consumption: 69.42,
        cylinderCapacity: 1955,
        fuel: 'Diesel',
        transmission: 'Manual',
        horsepower: 500,
        price: 4000,
      },
      {
        id: uuid(),
        consumption: 50,
        cylinderCapacity: 2455,
        fuel: 'Gasoline',
        transmission: 'Automatic',
        horsepower: 650,
        price: 6000,
      },
    ],
    options: [
      {
        id: uuid(),
        name: 'AC',
        value: 'Automatic',
        price: 500,
      },
    ],
    id: uuid(),
    price: 5000,
    numberOfDoors: 4,
    length: 5,
    manufacturer: 'Audi',
    model: 'A4',
    style: 'Sedan',
    weight: 1900,
    width: 2.2,
    warranty: 3,
  },
  {
    engines: [
      {
        id: uuid(),
        consumption: 69.42,
        cylinderCapacity: 1955,
        fuel: 'Diesel',
        transmission: 'Manual',
        horsepower: 500,
        price: 30000,
      },
      {
        id: uuid(),
        consumption: 50,
        cylinderCapacity: 2455,
        fuel: 'Gasoline',
        transmission: 'Automatic',
        horsepower: 650,
        price: 32000,
      },
    ],
    options: [
      {
        id: uuid(),
        name: 'AC',
        value: 'Manual',
        price: 2000,
      },
    ],
    id: uuid(),
    price: 7500,
    numberOfDoors: 5,
    length: 2,
    manufacturer: 'Audi',
    model: 'A7',
    style: 'Coupe',
    weight: 2700,
    width: 2.2,
    warranty: 3,
  },
  {
    engines: [
      {
        id: uuid(),
        consumption: 69.42,
        cylinderCapacity: 1955,
        fuel: 'Diesel',
        transmission: 'Manual',
        horsepower: 500,
        price: 80000,
      },
      {
        id: uuid(),
        consumption: 50,
        cylinderCapacity: 2455,
        fuel: 'Gasoline',
        transmission: 'Automatic',
        horsepower: 650,
        price: 10000,
      },
    ],
    options: [
      {
        id: uuid(),
        name: 'AC',
        value: 'Automatic',
        price: 1000,
      },
      {
        id: uuid(),
        name: 'AC',
        value: 'Manual',
        price: 1500,
      },
    ],
    id: uuid(),
    price: 6500,
    numberOfDoors: 4,
    length: 5,
    manufacturer: 'BMW',
    model: 'Series 5',
    style: 'Wagon',
    weight: 2100,
    width: 2.2,
    warranty: 3,
  },
];

const useStyles = makeStyles(() => ({
  root: {
    width: '100%',
    float: 'left',
  },
  actions: {
    justifyContent: 'flex-end',
  },
}));

const multiplyArray = (a) => {
  let b = [];

  for (var i = 0; i < a.length; ++i) {
    b.push(a[i]);
    b.push(a[i]);
  }
  return b;
};

const LatestOrders = ({ className, ...rest }) => {
  const classes = useStyles();
  const [vehicles] = useState(multiplyArray(data));
  vehicles.concat(vehicles);

  return (
    <Card className={clsx(classes.root, className)} {...rest}>
      <CardHeader title="Ajánlások" />
      <Divider />
      <Box width="100%">
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Gyártó</TableCell>
              <TableCell>Modell</TableCell>
              <TableCell>Kivitel</TableCell>
              <TableCell>Garancia</TableCell>
              <TableCell>Induló teljesítmény</TableCell>
              <TableCell>Induló ár</TableCell>
              <TableCell></TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {vehicles.map((vehicle) => (
              <TableRow hover key={vehicle.id}>
                <TableCell>{vehicle.manufacturer}</TableCell>
                <TableCell>{vehicle.model}</TableCell>
                <TableCell>{vehicle.style}</TableCell>
                <TableCell>{vehicle.warranty} Év</TableCell>
                <TableCell>{vehicle.engines[0].horsepower} Lóerő</TableCell>
                <TableCell>{vehicle.price} USD</TableCell>
                <TableCell>
                  <IconButton>
                    <MoreHorizIcon />
                  </IconButton>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </Box>
      <Box display="flex" justifyContent="center" p={2}>
        <Pagination count={10} showFirstButton showLastButton />
      </Box>
    </Card>
  );
};

LatestOrders.propTypes = {
  className: PropTypes.string,
};

export default LatestOrders;
