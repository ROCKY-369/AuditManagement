import { TestBed } from '@angular/core/testing';

import { DashGaurdGuard } from './dash-gaurd.guard';

describe('DashGaurdGuard', () => {
  let guard: DashGaurdGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(DashGaurdGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
